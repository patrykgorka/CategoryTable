Widget z tabelami kategorii do formatki dodawania i edytowania produktow.

Dane trzeba po stworzeniu obiektu ustawic setami bo inaczej tableki beda puste.
	
Przyklad ustawiania danych do formatki dodawania: 
- W tabeli dostepnych kategori beda znajdowac sie wszystkie dane
- Tabela z wybranymi kategoriami bedzie pusta

```ruby
CategoryChoosePanel categoryChoosePanel = new CategoryChoosePanel();;

categoryService.getAllCategories(new AsyncCallback<List<Category>>() {
			
	@Override
	public void onSuccess(List<Category> result) {
		categoryChoosePanel.setAvailableCategoriesList(result);
	}

	@Override
	public void onFailure(Throwable caught) {
	}
});
			
dialogBoxPanel.add(categoryChoosePanel);
```