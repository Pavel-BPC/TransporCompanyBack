package com.blinets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Item
{
  private String id;
  private String name;
  private double weight;
  private double price;

}