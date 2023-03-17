package seminar11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import seminar11.RobotMap.Direction;

public class Main {

    public static void main(String[] args) {
        // 1.
        // Карта с каким-то размером nxm.
        // На ней можно создать робов, указывая начальное положение.
        // Если начальное положение некорректное ИЛИ эта позиция занята другим робом, то
        // кидаем исключение.
        // Робот имеет направление (вверх, вправо, вниз, влево). У роботов можно менять
        // направление и передвигать их на 1 шаг вперед
        // 2.
        // Написать контроллер к этому коду, который будет выступать посредником между
        // консолью (пользователем) и этой игрой.
        // (0,0) ------------------ (0, m)
        // ...
        // (n, 0) ----------------------- (n, m)

        // Robot, Map, Point

        // Домашнее задание:
        // Реализовать чтение команд с консоли и выполнить их в main методе
        // Список команд:
        // create-map 3 5 -- РЕАЛИЗОВАНО!
        // create-robot 2 7
        // move-robot id
        // change-direction id LEFT

        Scanner sc = new Scanner(System.in);
        ArrayList<RobotMap.Robot> robots = new ArrayList<>();
        RobotMap map = null;
        System.out.println("Введите команду для создания карты:");
        System.out.println("create-map (n, m)\nfor example: create-map 5 5");
        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("create-map")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }

        }
        System.out.println();
        System.out.println("Карта создана! Игра началась.");
        System.out.println(
                "Команды для игры:\ncreate-robot(position) - create robot\nmove-robot(id) - move robot\nchange-direction(id, direction) - change direction(TOP, LEFT, BOTTOM, RIGHT)\nrobots - show your robots");
        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("create-robot")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                try {
                    RobotMap.Robot robot = map
                            .createRobot(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
                    robots.add(robot);
                    System.out.println("Робот создан!" + robot);

                } catch (PositionException e) {
                    System.out.println("При создании робота возникла ошибка!" + e.getMessage());
                }
            }
            if (command.startsWith("move-robot")) {
                String[] split = command.split(" ");
                int argument = Integer.parseInt(split[1]);

                try {
                    for (int i = 0; i < robots.size(); i++) {
                        int id = robots.get(i).getId();
                        if (id == argument) {
                            robots.get(i).move();
                            System.out.println("Позиция робота: " + robots.get(i).getPosition());
                        }
                    }
                } catch (Exception e) {
                    System.out.println("При движении робота возникла ошибка! " + e.getMessage());
                }
            }
            if (command.startsWith("change-direction")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                try {
                    for (int i = 0; i < robots.size(); i++) {
                        int id = robots.get(i).getId();
                        if (id == Integer.parseInt(arguments[0])) {
                            if (arguments[1].toUpperCase().equals("LEFT")) {
                                robots.get(i).changeDirection(Direction.LEFT);
                            }
                            if (arguments[1].toUpperCase().equals("RIGHT")) {
                                robots.get(i).changeDirection(Direction.RIGHT);
                            }
                            if (arguments[1].toUpperCase().equals("TOP")) {
                                robots.get(i).changeDirection(Direction.TOP);
                            }
                            if (arguments[1].toUpperCase().equals("BOTTOM")) {
                                robots.get(i).changeDirection(Direction.BOTTOM);
                            }
                        }
                    }
                    System.out.println("Направление изменено на " + arguments[1].toUpperCase());
                } catch (Exception e) {
                    System.out.println("При изменении направления возникла ошибка!" + e.getMessage());
                }
            }
            if (command.startsWith("robots")) {
                if (robots.size() != 0) {
                    System.out.println(robots);
                } else {
                    System.out.println("Список роботов пуст! Создайте робота.");
                }
            }
        }
    }
}
