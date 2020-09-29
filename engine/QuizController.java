package engine;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizController {
    private final List<Quiz> quizzes = new ArrayList<>();

    public QuizController() { }

    @PostMapping(path = "/api/quizzes", consumes = "application/json")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        quizzes.add(quiz);
        return quizzes.get(quizzes.size() - 1);
    }

    @PostMapping(path = "/api/quizzes/{id}/solve")
    public Result solveQuiz(@PathVariable int id, @RequestParam("answer") int answer) {
        if (id < 1 || id > quizzes.size()) {
            throw new NotFoundException();
        }
        if (answer == quizzes.get(id - 1).getAnswer()) {
            return new Result(true);
        } else {
            return new Result(false);
        }
    }

    @GetMapping(path = "/api/quizzes/{id}")
    @ResponseBody
    public Quiz getQuiz(@PathVariable int id) throws NotFoundException {
        if (id < 1 || id > quizzes.size()) {
            throw new NotFoundException();
        }
        return quizzes.get(id - 1);
    }

    @GetMapping(path = "/api/quizzes")
    public Quiz[] getQuizzes() {
        if (quizzes.isEmpty()) {
            return new Quiz[0];
        }
        Quiz[] quizArray = new Quiz[quizzes.size()];
        for (int i = 0; i < quizzes.size(); i++) {
            quizArray[i] = quizzes.get(i);
        }
        return quizArray;
    }

}