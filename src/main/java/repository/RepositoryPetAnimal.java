package repository;

import model.IAnimal;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPetAnimal {
    private List<IAnimal> listPetAnimals = new ArrayList<>();
    private List<Integer> listId = new ArrayList<>();

    public void add(IAnimal animal) {
        listPetAnimals.add(animal);
    }

    public void add(int id) {
        listId.add(id);
    }

    public int size() {
        return listId.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< listId.size(); i++) {
            sb.append("id: ").append(listId.get(i))
                    .append("  ")
                    .append(listPetAnimals.get(i))
                    .append("\n");
        }
        return sb.toString();
    }
}
