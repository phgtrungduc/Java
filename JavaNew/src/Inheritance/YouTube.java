package Inheritance;

public class YouTube {
    String name;
    int view,like,dislike;
    public YouTube() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }
    public void setAll(String name,int view,int like,int dislike){
        this.setName(name);
        this.setView(view);
        this.setLike(like);
        this.setDislike(dislike);
    }
    public void display(){
        System.out.printf("MV bài hát %s đạt %,d lượt xem trong đó có %,d lượt like và %,d lượt dislike",
                this.name,this.view,this.like,this.dislike);
    }
}
