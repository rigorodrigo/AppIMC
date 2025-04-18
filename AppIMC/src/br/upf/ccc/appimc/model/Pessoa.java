package br.upf.ccc.appimc.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe para instanciar os atributos da pessoa que quer calcular seu IMC
 *
 * @author Rodrigo Rigo
 */
@Entity
public class Pessoa {

    private String nome;
    @Id
    private String cpf;
    private Double peso;
    private Float altura;

    public Pessoa() {
    }

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }
    

    public Pessoa(String nome, String cpf, Double peso, Float altura) throws Exception {
        this.nome = nome;
        this.cpf = cpf;
        setPeso(peso);
        setAltura(altura);
    }

    public Double calcularIMC() {
        return (peso / (altura * altura));
    }

    public String interpretarIMC() {
        Double valorIMC = calcularIMC();
        if (valorIMC > 40.0) {
            return "Obesidade Grave";
        } else if (valorIMC > 30.0 && valorIMC <= 39.9) {
            return "Obesidade";
        } else if (valorIMC > 25.0 && valorIMC <= 29.9) {
            return "Sobrepeso";
        } else if (valorIMC > 18.5 && valorIMC <= 24.9) {
            return "Normalidade";
        } else {
            return "Magreza!";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) throws Exception {
        if (peso <= 0) {
            throw new Exception("Peso tem quer maior que 0");
        }
        else if (peso > 300) {
            throw new Exception ("Peso tem que ser menor que 300!"); 
        }
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) throws Exception {
        if (altura <= 0) {
            throw new Exception("Altura tem que ser maior que 0!");
        }
        else if (altura > 3) {
            throw new Exception ("Altura tem que ser menor que 3!");
        }
        this.altura = altura;
    }

    @Override
    public String toString() {
        return   "Nome = " + nome + ", CPF = " + cpf + ", Peso = " + peso + ", Altura = " + altura + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    }
    
    

}
