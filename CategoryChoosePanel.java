package com.cschool.shop.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.cschool.shop.shared.model.Category;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;

public class CategoryChoosePanel extends HorizontalPanel {

	List<Category<Long>> choseCategoriesList;
	List<Category<Long>> availableCategoriesList;

	CellTable<Category<Long>> availableCategoriesTable;
	CellTable<Category<Long>> chosenCategoriesTable;

	Button addCategoryButton;
	Button removeCategoryButton;

	public CategoryChoosePanel() {
		availableCategoriesList = new ArrayList<>();;
		choseCategoriesList = new ArrayList<>();

		VerticalPanel buttonPanel = new VerticalPanel();
		buttonPanel.setSpacing(5);

		ScrollPanel vailableCategoriesScrollPanel = new ScrollPanel();
		vailableCategoriesScrollPanel.setHeight("150px");
		vailableCategoriesScrollPanel.setWidth("150px");
		ScrollPanel chosenCategoriesScrollPanel = new ScrollPanel();
		chosenCategoriesScrollPanel.setHeight("150px");
		chosenCategoriesScrollPanel.setWidth("150px");

		availableCategoriesTable = new CellTable<>();
		availableCategoriesTable.setRowData(availableCategoriesList);
		MultiSelectionModel<Category<Long>> availableCategoriesSelectionModel = new MultiSelectionModel<Category<Long>>();
		availableCategoriesTable.setSelectionModel(availableCategoriesSelectionModel);

		chosenCategoriesTable = new CellTable<>();
		chosenCategoriesTable.setRowData(choseCategoriesList);
		MultiSelectionModel<Category<Long>> chosenCategoriesSelectionModel = new MultiSelectionModel<Category<Long>>();
		chosenCategoriesTable.setSelectionModel(chosenCategoriesSelectionModel);

		addCategoryButton = new Button();
		addCategoryButton.setText(">");
		removeCategoryButton = new Button();
		removeCategoryButton.setText("<");

		buttonPanel.add(addCategoryButton);
		buttonPanel.add(removeCategoryButton);
		
		chosenCategoriesScrollPanel.add(chosenCategoriesTable);
		vailableCategoriesScrollPanel.add(availableCategoriesTable);

		availableCategoriesTable.addColumn(new TextColumn<Category<Long>>() {

			@Override
			public String getValue(Category<Long> object) {
				return object.getName();
			}

		}, "Available");

		chosenCategoriesTable.addColumn(new TextColumn<Category<Long>>() {

			@Override
			public String getValue(Category<Long> object) {
				return object.getName();
			}

		}, "Chosen");

		addCategoryButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				choseCategoriesList.addAll(availableCategoriesSelectionModel.getSelectedSet());
				availableCategoriesList.removeAll(availableCategoriesSelectionModel.getSelectedSet());

				availableCategoriesSelectionModel.clear();
				chosenCategoriesSelectionModel.clear();

				chosenCategoriesTable.setRowData(choseCategoriesList);
				availableCategoriesTable.setRowData(availableCategoriesList);
			}
		});

		removeCategoryButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				availableCategoriesList.addAll(chosenCategoriesSelectionModel.getSelectedSet());
				choseCategoriesList.removeAll(chosenCategoriesSelectionModel.getSelectedSet());

				availableCategoriesSelectionModel.clear();
				chosenCategoriesSelectionModel.clear();

				chosenCategoriesTable.setRowData(choseCategoriesList);
				availableCategoriesTable.setRowData(availableCategoriesList);
			}
		});

		this.add(vailableCategoriesScrollPanel);
		this.add(buttonPanel);
		this.add(chosenCategoriesScrollPanel);

	}

	public List<Category<Long>> getChoseCategoriesList() {
		return choseCategoriesList;
	}

	public List<Category<Long>> getAvailableCategoriesList() {
		return availableCategoriesList;
	}

	public void setChoseCategoriesList(List<Category<Long>> choseCategoriesList) {
		this.choseCategoriesList = choseCategoriesList;
		chosenCategoriesTable.setRowData(choseCategoriesList);
	}

	public void setAvailableCategoriesList(List<Category<Long>> availableCategoriesList) {
		this.availableCategoriesList = availableCategoriesList;
		availableCategoriesTable.setRowData(availableCategoriesList);
	}
	
}
