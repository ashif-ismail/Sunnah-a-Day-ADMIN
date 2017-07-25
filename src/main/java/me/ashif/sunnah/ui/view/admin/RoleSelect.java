package me.ashif.sunnah.ui.view.admin;

import com.vaadin.ui.ComboBox;
import me.ashif.sunnah.backend.model.Role;

public class RoleSelect extends ComboBox<String> {

	public RoleSelect() {
		setCaption("Role");
		setEmptySelectionAllowed(false);
		setItems(Role.getAllRoles());
		setTextInputAllowed(false);
	}
}
