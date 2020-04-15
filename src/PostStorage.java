import exception.CategoryNotFoundException;
import exception.PostNotFoundException;

public class PostStorage<extend> implements PostStoragelmpl {


    private Post[] posts = new Post[15];
    private int size = 0;

    @Override
    public void add(Post post) {
        if (size == posts.length) {
            extend();
        }
        posts[size++] = post;
    }

    private void extend() {
        Post[] tmp = new Post[posts.length + 10];
        System.arraycopy(posts, 0, tmp, 0, posts.length);
        posts = tmp;

    }

    @Override
    public Post getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(title)) {
                return posts[i];
            }
        }
        throw new PostNotFoundException("There isn't that title");

    }


    @Override
    public void searchPostsByKeyword(String keyword) {
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().contains(keyword) || posts[i].getText().contains(keyword)) {
                System.out.println(posts[i]);
                isFound = true;
            }

        }
        if (!isFound) {
            System.out.println("There isn't that word");
        }

    }

    @Override
    public void printAllPosts() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }

    }

    @Override
    public void printPostsByCategory(String category) throws CategoryNotFoundException {
        boolean isf = false;
        for (int i = 0; i < size; i++) {
            if (posts[i].getCategory().equals(category)) {
                System.out.println(posts[i]);
                isf = true;
            }

            }
        if(!isf){
        throw new CategoryNotFoundException("There isn't that Category");
        }



    }
}

