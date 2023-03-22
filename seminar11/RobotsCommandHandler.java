package seminar11;

public class RobotsCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "robots";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
       System.out.println(map.getRobots());;
    }
    
}
