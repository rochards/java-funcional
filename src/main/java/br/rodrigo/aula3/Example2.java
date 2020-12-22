package br.rodrigo.aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Example2 {
    private static final ExecutorService PEOPLE_TO_EXECUTE_TASK = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {

        House house = new House(new BedRoom());
//        house.getHouseTasks().forEach( task -> PEOPLE_TO_EXECUTE_TASK.execute(() -> task.doIt()));
        List<? extends Future<?>> futures =
                new CopyOnWriteArrayList<>(house.getHouseTasks()
                        .stream()
                        .map(task -> PEOPLE_TO_EXECUTE_TASK.submit(task::doIt))
                        .collect(Collectors.toList()));
        // CopyOnWriteArrayList eh o que chamamos de thread safe. Uma simple List nao eh thread safe

        while (futures.stream().allMatch(Future::isDone)) {
            int tasksAlive = 0;
            for (Future<?> future : futures) {
                if (future.isDone()) {
                    try {
                        System.out.println("Parabens!, vc terminou de " + future.get());
                        futures.remove(future);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    tasksAlive++;
                }
            }
            System.out.println("Numero de atividades nao finalizadas: " + tasksAlive);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PEOPLE_TO_EXECUTE_TASK.shutdown(); // necessário para terminar o programa
    }
}

class House {

    private List<Room> rooms;

    public House(Room... rooms) {
        this.rooms = Arrays.asList(rooms);
    }

    public List<Task> getHouseTasks() {
        return this.rooms.stream()
                .map(Room::getRoomTasks)
                .reduce(new ArrayList<Task>(), (pivot, tasks) -> {
                    pivot.addAll(tasks);
                    return pivot;
                });
    }
}

@FunctionalInterface
interface Task {
    void doIt();
}

abstract class Room {
    abstract List<Task> getRoomTasks();
}

class BedRoom extends Room {

    private void task1(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Arrumar guarda roupas");
    }

    private void task2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Varrer o quarto");
    }

    private void task3() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Arrumar a cama");
    }

    @Override
    List<Task> getRoomTasks() {
        return Arrays.asList(
                this::task1, //- retornando as referencias dos metodos. Isso eh a mesma coisa de eu passar uma
                // expressao lambda, que sera associado ao metodo abstrato da classe Task
                this::task2,
                this::task3
        );
    }
}
