package ru.gp.server;

import ru.gp.server.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //    @RequestMapping(value = "/articles", method = {RequestMethod.GET,RequestMethod.OPTIONS} )
    @RequestMapping(value = "/articles")
//    @CrossOrigin(origins = {"http://127.0.0.1:8888","http://localhost:8888"})
    @CrossOrigin(origins = "*")
    public List<Article> getArticles() {
        return articleService.getAllArcticles();
    }

    @RequestMapping("/articles/{id}")
    public Article getArticle(@PathVariable String id) {
        return articleService.getArticle(id);
    }

    // Пример insert
    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{id}")
    public void updateArticle(@RequestBody Article article, @PathVariable String id) {
        articleService.updateArticle(article, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    public void deleteArticle(@RequestBody Article article, @PathVariable String id) {
        articleService.deleteArticle(id);
    }

}
