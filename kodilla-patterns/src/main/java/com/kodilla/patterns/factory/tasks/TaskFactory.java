package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    enum TaskType {
        DRIVING_TASK,
        PAINTING_TASK,
        SHOPPING_TASK
    }

    public final Task makeTask(final TaskType taskType) {
        switch (taskType) {
            case DRIVING_TASK:
                return new DrivingTask("Drive to doctor", "New York", "Rolls Royce");
            case PAINTING_TASK:
                return new PaintingTask("Paint with anitcorrosive", "black", "fence");
            case SHOPPING_TASK:
                return new ShoppingTask("Buy weekly food", "meat", 5.00);
            default:
                return null;
        }

    }

}
