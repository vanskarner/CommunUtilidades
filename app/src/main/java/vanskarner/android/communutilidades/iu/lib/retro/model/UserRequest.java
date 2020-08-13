package vanskarner.android.communutilidades.iu.lib.retro.model;

public class UserRequest {
    private String token;
    private int userId;
    private int id;
    private String title;
    private String body;

    public UserRequest(String token, int userId, int id, String title, String body) {
        this.token = token;
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
