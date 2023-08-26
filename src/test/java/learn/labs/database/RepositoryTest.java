package learn.labs.database;

import learn.labs.database.entity.Comment;
import learn.labs.database.repository.CommentRepository;
import learn.labs.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("hadi@test.com", "ho");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(2313);

        Assertions.assertNotNull(comment);

        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());

        Comment notFound = commentRepository.findById(1000000);
        Assertions.assertNull(notFound);
    }

    @Test
    void testFindAll() {
        List<Comment> comment = commentRepository.findAll();
        System.out.println(comment.size());
    }

    @Test
    void testFindByEmail() {
        List<Comment> comment = commentRepository.findByEmail("hadi@test.com");

        for (int i = 0; i < comment.size(); i++) {
            System.out.println(comment.get(i).getEmail());
            System.out.println(comment.get(i).getComment());
            System.out.println(comment.get(i).getId());
            System.out.println();
        }
    }
}
