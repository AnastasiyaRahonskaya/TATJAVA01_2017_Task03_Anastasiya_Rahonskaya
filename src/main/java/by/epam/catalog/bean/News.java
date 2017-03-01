package by.epam.catalog.bean;

import java.io.Serializable;

/**
 * Class contains constructor and getters
 * for News' class fields
 */
public class News implements Serializable {
  private String category;
  private String title;
  private String author;
  private String date;

  public News() {
  }

  public News(String category, String title, String author, String date) {
    this.category = category;
    this.title = title;
    this.author = author;
    this.date = date;
  }

  /**
   * getter for category
   *
   * @return category
   */
  public String getCategory() {
    return category;
  }

  /**
   * getter for title
   *
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * getter for author
   *
   * @return author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * getter for date
   *
   * @return category
   */
  public String getDate() {
    return date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    News news = (News) o;

    if (getCategory() != null ? !getCategory().equals(news.getCategory()) : news.getCategory() != null)
      return false;
    if (getTitle() != null ? !getTitle().equals(news.getTitle()) : news.getTitle() != null) return false;
    if (getAuthor() != null ? !getAuthor().equals(news.getAuthor()) : news.getAuthor() != null) return false;
    return getDate() != null ? getDate().equals(news.getDate()) : news.getDate() == null;
  }

  @Override
  public int hashCode() {
    int result = getCategory() != null ? getCategory().hashCode() : 0;
    result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
    result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
    result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "category = '" + category + '\'' +
        ", title = '" + title + '\'' +
        ", author = '" + author + '\'' +
        ", date = '" + date + '\'';
  }
}
