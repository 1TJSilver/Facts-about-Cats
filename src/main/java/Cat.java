import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    private String id;
    private String text;
    private String user;
    private String type;
    private Integer upVotes;

    public Cat (
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("user") String user,
            @JsonProperty("type") String type,
            @JsonProperty("upvotes") Integer upVotes
    ){
        this.id = id;
        this.text = text;
        this.user = user;
        this.type = type;
        this.upVotes = upVotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Text: " + text + "\n" +
                "User: " + user + "\n" +
                "Type: " + type + "\n" +
                "Upvotes: " + upVotes + "\n";
    }
}
