package lessons.sort.basic.cocktail;

import plm.core.model.Game;
import plm.core.model.lesson.ExerciseTemplated;
import plm.core.model.lesson.Lesson;
import plm.universe.sort.SortingWorld;

public class AlgCocktailSort3 extends ExerciseTemplated {
	
	public AlgCocktailSort3(Game game, Lesson lesson) {
		super(game, lesson);
		
		SortingWorld[] myWorlds = new SortingWorld[2];
		myWorlds[0] = new SortingWorld(game, "Functional test",10);
		myWorlds[1] = new SortingWorld(game, "Performance test (150 elms)",150);

		setup(myWorlds);
	}
}
