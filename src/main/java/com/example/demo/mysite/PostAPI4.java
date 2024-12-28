//package com.example.demo.mysite;
//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("v4/posts")  //class로 전체로 전달됨
//public class PostAPI4 {
//
//    //Post class 의 instance, 즉 게시글을 넣을 List랠 생성
//    List<Post> posts = new ArrayList<>();  //sleect, create, delete ;delegate DB role to it
//    private Long id = 0L; //게시글 생성에서 id 생성을 위한 장치
//
//    {
//        //3 초기화 블록
//        //인스턴스가 생성되었을 때 한번 실행된다.
//        posts.add(new Post(++id, "초기 제목", "초기 내용"));
//    }
//
//    //create
//
//    //post/content/url
//    //url에 내용을 실어 보내자
//    @PostMapping
//    public Post createPost(@RequestBody Post newPost) {
//        System.out.println(newPost.getTitle());
//        System.out.println(newPost.getContent());
//
//        String title=newPost.getTitle();
//        String content=newPost.getContent();
//
//       //유효성 체크
//        if(title==null||title.isBlank()) {
//            throw new RuntimeException("enter title");
//
//        }
//        if(content==null||content.isBlank()) {
//            throw new IllegalArgumentException("enter content");
//
//        }
//        Post post = new Post(++id, title, content);
//        posts.add(post);
//        return post;
//    }
//
//    @GetMapping("")   //전체 조회
//    public List<Post> readPosts() {
//        return posts;
//    }
//
//
//    //4 단일 조회 : 내용을 구분하기 위해 id가 필요하다.
//    @GetMapping("/{id}")   //id가 변수처럼 기능  posts/1,posts/2,...
//    @ResponseStatus(HttpStatus.CREATED)
//    public Post readPostById(@PathVariable Long id) { //method 내보웨서 사용해야 하므로 받아와야 한다. 경로상에 있는 id를 받아온다
//
//        //posts에서 post를 가져오자
//        for (Post post : posts) {
//            if (post.getId().equals(id)) {
//                return post;
//            }
//
//        }
//        return null;
//
//    }
//
//
//    //5. update
//    //변경 내용/id/url
//    @PutMapping("{id}")
//    public Post updatePost(@PathVariable  Long id,@RequestBody Post updatePost) {
//        String newTitle=updatePost.getTitle();
//        String newContent=updatePost.getContent();
//
//
////        if(updatePost.getTitle()==null||updatePost.getTitle().isBlank()){
////            throw new RuntimeException("enter title");
////
////        }
////        if(updatePost.getContent()==null||updatePost.getContent().isBlank()){
////            throw new IllegalArgumentException("enter content");
////        }
//
//        for (Post post : posts) {
//            if (post.getId().equals(id)) {
//                post.setTitle("수정된 제목");
//                post.setContent("수정된 내용");
//              return post;
//            }
//
//        } return null;
//
//
//    }
//
//
//    //6. delete
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public String deletePost(@PathVariable Long id) {
//        for (Post post : posts) {
//            if(post.getId().equals(id)) {
//                posts.remove(post);
//
//                return "게시글이 삭제되었습니다.";
//            }
//
//        } return "게시글이 존재하지 않습니다.";
//    }
//
////    @GetMapping("/paged")
////    public List<Post> getPagedPosts(@RequestParam int page, @RequestParam int size){
////
////        // 1. 페이지네이션을 위한 더미데이터 추가
////        for (int i = 1; i <= 20; i++) {
////            String title = "제목" + i;
////            String content = "내용" + i;
////            Post post = new Post(++id, title, content);
////            posts.add(post);
////        }
////
////
////
////        // 2. 시작 인덱스와 끝 인덱스 계산
////
////        int startIndex = (page - 1) * size;
////        int endIndex = Math.min(startIndex + size, posts.size());
////
////        // 3. 페이지에 해당하는 데이터만 추출
////        return Posts.subList(startIndex, endIndex);
////    }
//
//    @GetMapping("/paged")
//    public List<Post> getPagedPosts(@RequestParam(defaultValue = "1") int page,
//                                    @RequestParam(defaultValue = "3") int size,
//                                    @RequestParam(defaultValue = "") String search){
//
//        // 1. 페이지네이션을 위한 더미데이터 추가
//        for (int i = 1; i <= 20; i++) {
//            String title = "제목" + i;
//            String content = "내용" + i;
//            Post post = new Post(++id, title, content);
//            posts.add(post);
//        }
//
//
//        // 2. 검색어를 포함하는 게시글만 필터링
//        List<Post> filteredPosts = posts.stream()
//                .filter(post -> post.getContent().contains(search))
//                .collect(Collectors.toList());
//
//        // 3. 시작 인덱스와 끝 인덱스 계산
//
//        int startIndex = (page - 1) * size;
//        int endIndex = Math.min(startIndex + size, posts.size());
//
//        // 4. 페이지에 해당하는 데이터만 추출
//        return filteredPosts.subList(startIndex, endIndex);
//    }
//}