package com.fer.aula04_recyclerview;

public class ItemData {
   private String nome;
   private String data;
   private int imgId;

   public ItemData() {
   }

   public ItemData(String nome, String data, int imgId) {
      this.nome = nome;
      this.data = data;
      this.imgId = imgId;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public int getImgId() {
      return imgId;
   }

   public void setImgId(int imgId) {
      this.imgId = imgId;
   }
}
