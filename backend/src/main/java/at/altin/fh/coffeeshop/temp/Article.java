package at.altin.fh.coffeeshop.temp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Article {
    @Id
    private Long id;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
