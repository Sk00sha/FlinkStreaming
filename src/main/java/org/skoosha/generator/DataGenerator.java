package org.skoosha.generator;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * Class that implements source-function to generate data into stream
 */
public class DataGenerator implements SourceFunction<Integer> {
    private boolean running = true;
    private int generatedNumber = 0;
    private int millisSleep = 1000;
    @Override
    public void run(SourceContext sourceContext) throws Exception {
        while (running){
            sourceContext.collect(generatedNumber);
            generatedNumber += 1;
            Thread.sleep(millisSleep);
        }
    }

    @Override
    public void cancel() {
        running = false;
    }
}
