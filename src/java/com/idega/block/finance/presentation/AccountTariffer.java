package com.idega.block.finance.presentation;

import com.idega.block.finance.business.FinanceFinder;
import com.idega.block.finance.data.TariffGroup;
import com.idega.block.finance.data.Tariff;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.PresentationObject;
import com.idega.presentation.IWContext;
import com.idega.presentation.Block;
import com.idega.presentation.Table;
import com.idega.presentation.ui.*;
import com.idega.presentation.text.*;
import com.idega.util.text.Edit;
import java.util.List;


/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author <a href="mailto:aron@idega.is">aron@idega.is
 * @version 1.0
 */

public class AccountTariffer extends Block {

  private final static String IW_BUNDLE_IDENTIFIER="com.idega.block.finance";
  protected IWResourceBundle iwrb;
  protected IWBundle iwb,core;
  private boolean isAdmin = false;

  public AccountTariffer() {
  }

   protected void control(IWContext iwc){
    /*
    java.util.Enumeration E = iwc.getParameterNames();
    while(E.hasMoreElements()){
      String prm = (String) E.nextElement();
      System.err.println("prm "+prm+" : "+iwc.getParameter(prm));
    }
    */
    if(isAdmin){
      int iCategoryId = Finance.parseCategoryId(iwc);
    }

  }

  private PresentationObject getTariffTable(int iTariffGroupId){
    List listOfTariffs = FinanceFinder.listOfTariffs(iTariffGroupId);
    Table T = new Table(1,2);
    if(listOfTariffs!=null){
      java.util.Iterator I = listOfTariffs.iterator();
      Tariff tariff;
      int row = 1;
      while(I.hasNext()){
        tariff = (Tariff) I.next();
        CheckBox chk = new CheckBox("trfchk",String.valueOf(tariff.getID()));
        T.add(chk,1,row);
        T.add(Edit.formatText(tariff.getName()),2,row);
        T.add(Edit.formatText(Float.toString(tariff.getPrice())),3,row);
      }
     // T.add(new HiddenInput("trf_count"));
    }
    return T;
  }

  private PresentationObject getTariffPropertiesTable(){
    Table T = new Table();


    return T;
  }

     private Table makeAdjustTable(){
      Table T2 = new Table(1,3);
      /*
      T2.setCellspacing(1);
      T2.setCellpadding(2);
      T2.setWidth("100%");
      Table T = new Table(3,2);
      T.setWidth("100%");
      T.setCellspacing(0);
      T.setCellpadding(2);
      T.setColumnAlignment(1,"left");
      T.setColumnAlignment(2,"left");
      T.setRowColor(1,HeaderColor);

      String fontColor = WhiteColor;
      int fontSize = 1;

      String sSettings = iwrb.getLocalizedString("settings","Settings");
      String sPaytype = iwrb.getLocalizedString("paytype","Paytype");
      String sFirstpaydate = iwrb.getLocalizedString("firstpaydate","1.Paydate");
      String sPayments = iwrb.getLocalizedString("payments","Payments");

      Text Title = new Text(sSettings,true,false,false);
      Title.setFontColor(HeaderColor);
      T2.add(Title,1,1);

      Text[] TableTitles = new Text[3];
      TableTitles[0] = new Text(sPayments);
      TableTitles[1] = new Text(sPaytype);
      TableTitles[2] = new Text(sFirstpaydate);

      for(int i = 0 ; i < TableTitles.length;i++){
        TableTitles[i].setFontSize(fontSize);
        TableTitles[i].setFontColor(WhiteColor);
        T.add(TableTitles[i],i+1,1);
      }

      DropdownMenu drdInst = new DropdownMenu("trf_ins");
      for(int i = 0; i < 13; i++){
        drdInst.addMenuElement( String.valueOf(i));
      }
      drdInst.setSelectedElement("1");

      DropdownMenu drdPaytypes = new DropdownMenu("trf_type");
      for(int i = 1; i < 5; i++){
        drdPaytypes.addMenuElement( String.valueOf(i),this.getPaymentType(i));
      }

      TextInput PayDate = new TextInput(this.getDtPrm());
      PayDate.setLength(10);
      PayDate.setAttribute("style",this.styleAttribute);

      IntegerInput Interest = new IntegerInput(this.getInterestprm());
      Interest.setLength(4);
      Interest.setAttribute("style",this.styleAttribute);

      IntegerInput Cost = new IntegerInput(this.getCostprm());
      Cost.setLength(4);
      Cost.setAttribute("style",this.styleAttribute);

      Table CostTable = new Table(4,1);
      CostTable.setWidth("100%");
      CostTable.setColumnAlignment(1,"left");
      CostTable.setColumnAlignment(2,"right");
      CostTable.setColumnAlignment(3,"left");
      CostTable.setColumnAlignment(4,"right");
      String sAmount = iwrb.getLocalizedString("amount","Amount");
      String sPercent = iwrb.getLocalizedString("percent","Percent");
      Text cost = new Text(sAmount);
      cost.setFontSize(fontSize);
      cost.setFontColor(HeaderColor);
      CostTable.add(cost,1,1);
      CostTable.add(Cost,2,1);
      Text interest = new Text(sPercent);
      interest.setFontSize(fontSize);
      interest.setFontColor(HeaderColor);
      CostTable.add(interest,3,1);
      CostTable.add(Interest,4,1);


      T.add(drdInst,1,2);
      T.add(drdPaytypes,2,2);
      T.add(PayDate,3,2);
      T2.add(T,1,2);
      T2.add(CostTable,1,3);
      */
      return T2;
    }

  private DropdownMenu getIntDrop(String name,int start, int end, String selected){
    DropdownMenu drp = new DropdownMenu(name);
    for (int i = start; i <= end; i++) {
      drp.addMenuElement(String.valueOf(i));
    }
    drp.setSelectedElement(selected);
    return drp;
  }

  public String getBundleIdentifier(){
    return IW_BUNDLE_IDENTIFIER;
  }

  public void main(IWContext iwc){
    iwrb = getResourceBundle(iwc);
    iwb = getBundle(iwc);
    core = iwc.getApplication().getCoreBundle();
    isAdmin = iwc.hasEditPermission(this);
    control(iwc);
  }
}