package com.somallg.design.pattern.chapter09.composite.client;

import com.somallg.design.pattern.chapter09.composite.component.MenuComponent;
import com.somallg.design.pattern.chapter09.composite.component.impl.Menu;
import com.somallg.design.pattern.chapter09.composite.component.impl.MenuItem;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pacakeHouseMenu =
                new Menu("Pancake House Menu", "Breakfast");
        MenuComponent dinerMenu = new Menu("Diner Menu", "Lunch");
        MenuComponent cafeMenu = new Menu("Cafe Menu", "Dinner");
        MenuComponent dessertMenu = new Menu("Dessert Menu", "Dessert");

        MenuComponent allMenus = new Menu("All Menu", "All Menu Combined");

        allMenus.add(pacakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        pacakeHouseMenu.add(new MenuItem("Regular Pancake",
                "Regular Pancake",
                true,
                2.99));

        pacakeHouseMenu.add(new MenuItem("Blueberry Pancake",
                "Blueberry Pancake",
                true,
                3.49));

        pacakeHouseMenu.add(new MenuItem("Waffles",
                "Yummy Waffles",
                true,
                3.59));

        dinerMenu.add(new MenuItem("Pumpkin Soup",
                "Yummy Pumpkin Soup",
                true,
                3.29));
        dinerMenu.add(new MenuItem("Hotdog",
                "Yummy Hotdog",
                false,
                3.05));

        dessertMenu.add(new MenuItem("Pasta",
                "Spaghetti with Marinara Sauce",
                true,
                3.89));

        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();

        waitress.printVegetarianMenu();
    }
}
