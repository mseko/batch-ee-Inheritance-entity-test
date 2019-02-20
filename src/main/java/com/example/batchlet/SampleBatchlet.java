package com.example.batchlet;

import com.example.entity.SampleUser;
import nablarch.common.dao.EntityList;
import nablarch.common.dao.UniversalDao;
import nablarch.core.log.Logger;
import nablarch.core.log.LoggerManager;

import javax.batch.api.AbstractBatchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Comparator;
import java.util.Optional;

/**
 * selectとinsertの実験用クラス<br>
 * selectしたレコードのIDだけ変更して、insertする。<br>
 * <br>
 * 本クラスを実行すると、レコード数が倍に増える。
 */
@Dependent
@Named
public class SampleBatchlet extends AbstractBatchlet {

    /** ロガー。 */
    private static final Logger LOGGER =
            LoggerManager.get(SampleBatchlet.class);

    @Override
    public String process() {
        EntityList<SampleUser> userDataList = UniversalDao.findAll(SampleUser.class);
        //現在存在する最大のユーザIDを取得する。
        int existingMaxUserId = userDataList
                .stream()
                .max(Comparator.comparing(SampleUser::userIdToInteger))
                .get().userIdToInteger();
        int i = 1;
        for (SampleUser sampleUser : userDataList) {
            sampleUser.setUserId(Integer.toString(existingMaxUserId + i ));
            UniversalDao.insert(sampleUser);
            i++;
        }
        LOGGER.logInfo("登録件数：" + (i - 1) + "件");
        return "SUCCESS";
    }

    private static int compareSampleUserId(SampleUser o1, SampleUser o2){
        return Integer.valueOf(o1.getUserId()).compareTo(Integer.valueOf(o2.getUserId()));
    }
}
