package org.skoosha.Generator;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class DataGenerator implements SourceFunction {
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
