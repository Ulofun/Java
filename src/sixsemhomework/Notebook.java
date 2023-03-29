package sixsemhomework;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter

public class Notebook {

  private String producer;
  private Double memory;
  private Double hardDisk;
  private String color;
  private Double diagonal;

  public Notebook(String producer, Double memory, Double hardDisk, String color, Double diagonal) {
    this.producer = producer;
    this.memory = memory;
    this.hardDisk = hardDisk;
    this.color = color;
    this.diagonal = diagonal;
  }

  @Override
  public String toString() {
    return "Производитель = '" + producer + '\'' +
        ", Оперативная память = " + memory + " MB" +
        ", Жёсткий диск = " + hardDisk + " GB" +
        ", Цвет ='" + color + '\'' +
        ", Диагональ = " + diagonal + "\"";
  }

  public void printNoteBooks() {
    System.out.println(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Notebook notebook = (Notebook) o;
    return Objects.equals(producer, notebook.producer)
        && Objects.equals(memory, notebook.memory)
        && Objects.equals(hardDisk, notebook.hardDisk)
        && Objects.equals(color, notebook.color)
        && Objects.equals(diagonal, notebook.diagonal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(producer, memory, hardDisk, color, diagonal);
  }
}
