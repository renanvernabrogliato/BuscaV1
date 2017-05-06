package br.usjt.ftce.desmob.clientev1;

import java.io.Serializable;

/**
 * Created by arqdsis on 03/03/2017.
 */
public class Cliente implements Serializable, Comparable<Cliente> {
    private String name;
    private String capital;
    private String area;
    private String population;

    public Cliente(String name, String capital, String area, String population) {
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPopulation(String population) { this.population = population; }

    public String getPopulation(){ return population;}


    public String getImagem() {
        String foto = this.area.replace('@', '_');
        return foto.replace('.', '_');
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", area='" + area + '\'' +
                ", population='" + population + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (!name.equals(cliente.name)) return false;
        if (!capital.equals(cliente.capital)) return false;
        if (!population.equals(cliente.population)) return false;
        return area.equals(cliente.area);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + capital.hashCode();
        result = 31 * result + area.hashCode();
        result = 31 * result + population.hashCode();
        return result;
    }

    @Override
    public int compareTo(Cliente cliente) {
        return this.name.compareTo(cliente.getName());
    }
}