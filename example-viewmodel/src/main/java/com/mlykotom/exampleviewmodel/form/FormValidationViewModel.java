package com.mlykotom.exampleviewmodel.form;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mlykotom.valifi.ValiFiForm;
import com.mlykotom.valifi.fields.ValiFieldEmail;
import com.mlykotom.valifi.fields.ValiFieldPassword;
import com.mlykotom.valifi.fields.ValiFieldPhone;

import eu.inloop.viewmodel.AbstractViewModel;


public class FormValidationViewModel extends AbstractViewModel<FormValidationView> {
	public final ValiFieldEmail email = new ValiFieldEmail();
	public final ValiFieldPassword password = new ValiFieldPassword();
	public final ValiFieldPassword password2 = new ValiFieldPassword();
	public final ValiFieldPhone phone = new ValiFieldPhone();
	public final ValiFiForm form = new ValiFiForm(email, password, password2, phone);


	@Override
	public void onCreate(@Nullable Bundle arguments, @Nullable Bundle savedInstanceState) {
		super.onCreate(arguments, savedInstanceState);
		phone.setEmptyAllowed(true);
		password2.addVerifyFieldValidator("Passwords must be the same", password);
	}

	@Override
	public void onDestroy() {
		form.destroy();
		super.onDestroy();
	}
}
