package org.example;

public class FakeResultGenerator implements ResultGenerator {
    @Override
    public Result generate() {
        return new Result(50);
    }
}
