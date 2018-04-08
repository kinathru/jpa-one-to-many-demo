package com.example.jpa.jpaonetomanydemo;

import com.example.jpa.jpaonetomanydemo.model.Comment;
import com.example.jpa.jpaonetomanydemo.model.Post;
import com.example.jpa.jpaonetomanydemo.repository.CommentRepository;
import com.example.jpa.jpaonetomanydemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaOneToManyDemoApplication implements CommandLineRunner
{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    public static void main( String[] args )
    {
        SpringApplication.run( JpaOneToManyDemoApplication.class, args );
    }


    @Override
    public void run( String... args ) throws Exception
    {
        commentRepository.deleteAllInBatch();
        postRepository.deleteAllInBatch();

        Post post = new Post( "Hibernate One-To-Many Mapping Example",
                "Learn how to use one to many mapping in hibernate",
                "Entire Post Content with sample code" );

        Comment comment = new Comment( "Great Article" );
        comment.setPost( post );

        Comment comment2 = new Comment( "Great Article 2" );
        comment2.setPost( post );

        Comment comment3 = new Comment( "Great Article 3" );
        comment3.setPost( post );

        post.getComments().add( comment );
        post.getComments().add( comment2 );
        post.getComments().add( comment3 );

        postRepository.save( post );

    }
}
