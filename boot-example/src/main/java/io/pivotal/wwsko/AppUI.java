package io.pivotal.wwsko;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by azwickey on 12/30/15.
 */
@SpringUI
@Theme("valo")
public class AppUI extends UI {

    private final DataRepository _repo;
    private final Grid _grid;

    @Autowired
    public AppUI(DataRepository repo) {
        _repo = repo;
        _grid = new Grid();
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(_grid);
        _grid.setWidth(100, Unit.PERCENTAGE);
        _grid.setHeight(100, Unit.PERCENTAGE);
        Collection<Model> collection = new ArrayList<Model>();
        _repo.findAll().forEach(collection::add);
        _grid.setContainerDataSource(new BeanItemContainer<Model>(Model.class, collection));
    }
}
