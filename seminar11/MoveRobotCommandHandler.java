package seminar11;

public class MoveRobotCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "move-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        int robotId = Integer.parseInt(args[0]);

        RobotMap.Robot robot = map.findRobotById(robotId);
        if (robot != null) {
            try {
                robot.move();
            } catch (PositionException e) {
                System.out.println("При движении робота произошла ошибка " + e.getMessage());
            }
            System.out.println("Позиция робота" + robot.getPosition());
        } else {
            System.out.println("Робот с идентификатором " + robotId + " не найден");
        }
    }

}
