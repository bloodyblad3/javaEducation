package seminar11;

public class HelpCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "help";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        System.out.println(
                "Команды для игры:\ncreate-robot(position) - create robot\nmove-robot(id) - move robot\nchange-direction(id, direction) - change direction(TOP, LEFT, BOTTOM, RIGHT)\nrobots - show your robots");
    }

}