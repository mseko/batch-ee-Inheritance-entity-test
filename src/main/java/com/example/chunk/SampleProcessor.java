package com.example.chunk;

import com.example.entity.SampleUser;
import com.example.form.SampleUserForm;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * 疎通確認用ItemProcessor実装クラス。
 * Processorが正常に動作することを確認する。
 * @deprecated TODO 疎通確認が終わったら削除すること。
 */
@Dependent
@Named
public class SampleProcessor implements ItemProcessor {

    /**
     * {@link SampleReader}から渡されたSampleUserのデータを編集し、出力用formクラスに
     * 設定して返却している。
     *
     * @param o Readerから渡されたデータ
     * @return 処理したデータ
     */
    @Override
    public Object processItem(Object o) {
        SampleUser userData = (SampleUser) o;
        SampleUserForm form = new SampleUserForm();
        form.setUserId(userData.getUserId());
        form.setName(userData.getFamilyName() + " " + userData.getFirstName());
        return form;
    }

}
