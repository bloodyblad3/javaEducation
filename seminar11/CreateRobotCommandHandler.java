package seminar11;

public class CreateRobotCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "create-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        try {
            RobotMap.Robot robot = map
                    .createRobot(new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
            System.out.println("Робот создан! " + robot);

        } catch (PositionException e) {
            System.out.println("При создании робота возникла ошибка! " + e.getMessage());
        }
    };
}
