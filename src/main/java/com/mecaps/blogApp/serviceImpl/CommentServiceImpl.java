package com.mecaps.blogApp.serviceImpl;

import com.mecaps.blogApp.entity.Comment;
import com.mecaps.blogApp.entity.Post;
import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.CommentRepository;
import com.mecaps.blogApp.repository.PostRepository;
import com.mecaps.blogApp.repository.UsersRepository;
import com.mecaps.blogApp.requestDTO.CommentRequestDTO;
import com.mecaps.blogApp.responseDTO.CommentResponseDTO;
import com.mecaps.blogApp.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {


    private CommentRepository commentRepository;
    private UsersRepository usersRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              UsersRepository usersRepository,
                              PostRepository postRepository) {

        this.commentRepository = commentRepository;
        this.usersRepository = usersRepository;
        this.postRepository = postRepository;
    }




    @Override
    public CommentResponseDTO createComment(CommentRequestDTO requestDTO) {

        Users user = usersRepository.findById(requestDTO.getAuthorId()).orElseThrow(
                () -> new RuntimeException("User id not found : " + requestDTO.getAuthorId()));

        Post post = postRepository.findById(requestDTO.getPostId()).orElseThrow(
                () -> new RuntimeException("Post id not found : " + requestDTO.getPostId()));

        Comment comment = new Comment();

        comment.setCommentString(requestDTO.getCommentString());
        comment.setAuthor(user);
        comment.setPost(post);

        Comment save = commentRepository.save(comment);
        return new CommentResponseDTO(save);
    }





    @Override
    public List<CommentResponseDTO> getAllCommentByAuthor(Long authorId) {

        List<Comment> all = commentRepository.findByAuthor_Id(authorId);
        return all.stream().map(CommentResponseDTO::new).toList();



//        List<CommentResponseDTO> commentResponseDTOS = new ArrayList<>();
//        for (Comment comment : all){
//            CommentResponseDTO commentRep = new CommentResponseDTO(comment);
//            commentResponseDTOS.add(commentRep);
//        }
//        return commentResponseDTOS;

    }

    @Override
    public CommentResponseDTO commentUpdate(Long commentId, CommentRequestDTO requestDTO) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow( () -> new RuntimeException("Comment id not found : " + commentId));

        comment.setCommentString(requestDTO.getCommentString());

        Comment save = commentRepository.save(comment);

        CommentResponseDTO commentResponseDTO = new CommentResponseDTO(save);

        return commentResponseDTO;
    }





    @Override
    public List<CommentResponseDTO> getAllComment() {

        List<Comment> commentList = commentRepository.findAll();

        return commentList.stream().map(CommentResponseDTO::new).toList();
    }

    @Override
    public String deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow( () -> new RuntimeException("Comment id not found : " + commentId));


        commentRepository.delete(comment);
        return "Comment deleted successfully!";
    }


}
