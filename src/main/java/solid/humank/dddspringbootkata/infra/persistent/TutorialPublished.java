package solid.humank.dddspringbootkata.infra.persistent;

public class TutorialPublished {
    private final String title;

    public TutorialPublished(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
