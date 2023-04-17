package toysshop;

package toysshop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Toys {

  private int id;
  private String name;
  private int weight;

  public Toys(int toyId, String toyName, int toyWeight) {
    this.id = toyId;
    this.name = toyName;
    this.weight = toyWeight;
  }

  @Override
  public String toString() {
    return id + "." + " Игрушка " + "\"" + name + "\"" + " в количестве: " + weight + " штук(а)";
  }

  public void printInfo() {
    System.out.println(this);
  }
}
