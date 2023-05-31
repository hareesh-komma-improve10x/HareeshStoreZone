package com.improve10x.hareeshstorezone.categories;

import com.improve10x.hareeshstorezone.model.Product;

public interface OnItemActionListener {

    void onItemClicked(Product products);
    void onItemDelete(Product products);

}
