package com.example.batchlet;

import com.example.chunk.SampleProcessor;
import com.example.entity.SampleUser;
import nablarch.common.dao.UniversalDao;
import nablarch.test.core.db.DbAccessTestSupport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link SampleProcessor}のテストクラス
 */
public class SampleBatchletTest extends DbAccessTestSupport{

    /**
     * {@link SampleBatchlet#process()} のテスト
     */
    @Test
    public void testProcess() {
        SampleBatchlet target = new SampleBatchlet();
        target.process();

        //assertは略
    }
}
