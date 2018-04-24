package com.undead.nosavvy.menuspluspersistence.repositories;

import com.orm.SugarRecord;
import com.undead.nosavvy.menuspluspersistence.models.Item;

import java.util.List;

/**
 * Created by nosavvy on 4/20/18.
 */

public class ItemRepository {
    public static List<Item> list(){
        List<Item> items = SugarRecord.listAll(Item.class);
        return items;
    }

    public static void create(String name, String category,Double price, String description, String state){
        Item item = new Item(name,category,price,description,state);
        SugarRecord.save(item);
    }

    public static List<Item> selectNormalAndFavorites(){
        List<Item> items = SugarRecord.find(Item.class,"estado IN (?,?)",new String[]{"favorito","normal"});
        return items;
    }

    public static void updateEstadoArchivado(Long id){
        Item item = SugarRecord.findById(Item.class,id);
        item.setEstado("archivado");
        SugarRecord.save(item);
    }

    public static void updateEstadoFavorito(Long id){
        Item item = SugarRecord.findById(Item.class,id);
        item.setEstado("favorito");
        SugarRecord.save(item);
    }
}
