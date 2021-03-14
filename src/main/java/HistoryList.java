import java.util.ArrayList;
import java.util.List;

public class HistoryList {
	List<ICommand> commands = new ArrayList<ICommand>();
	int lastCommand = -1;

	public void addCommand(ICommand command) {
		lastCommand++;
		commands.add(lastCommand, command);
	}

	public void undo() {
		if (lastCommand > -1) {
			commands.get(lastCommand).unexecute();
			lastCommand--;
		}
	}

	public void redo() {
		if (lastCommand < commands.size()-1) {
			commands.get(lastCommand).unexecute();
			lastCommand++;
		}
	}

}
