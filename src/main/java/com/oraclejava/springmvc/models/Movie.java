package com.oraclejava.springmvc.models;

import com.oraclejava.springmvc.Price;
import com.oraclejava.springmvc.ReleaseYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movie")  //movie이라는 이름의 테이블과 매핑한다.
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50, nullable = false)
    @NotBlank
    private String name;

//    @NotNull(message = "가격은 필수입력입니다.")
//    @Min(value = 0, message = "가격은 음수일 수 없습니다.")
//    @Max(value = 50000, message = "가격은 50000원을 넘을 수 없습니다.")
//    @Price
    @Price
    private Integer price;

//    @NotNull(message = "개봉년도를 입력하세요.")
//    @Min(value = 1895)
//    @Max(value = 2029)
    @ReleaseYear
    private Integer releaseYear;

    @ManyToOne(optional = false)
    @JoinColumn (name = "genre_id")
    private Genre genre;

    @Transient
    private long genreId;

    public Movie() {

    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                ", genreId=" + genreId +
                '}';
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
