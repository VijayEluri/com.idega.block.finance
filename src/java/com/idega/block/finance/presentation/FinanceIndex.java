/*
 * $Id: FinanceIndex.java,v 1.4 2001/12/19 13:24:46 aron Exp $
 *
 * Copyright (C) 2001 Idega hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 *
 */
package com.idega.block.finance.presentation;

import com.idega.presentation.BlockMenu;
import com.idega.presentation.text.*;
import com.idega.presentation.ui.IFrame;
import com.idega.presentation.*;
import com.idega.presentation.Table;
import com.idega.presentation.PresentationObject;
import com.idega.presentation.IWContext;
import com.idega.block.finance.presentation.*;
import com.idega.block.finance.business.FinanceObject;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.block.text.presentation.TextReader;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author <a href="mailto:aron@idega.is">aron@idega.is</a>
 * @version 1.0
 */
public class FinanceIndex extends Block {

  private final static String IW_BUNDLE_IDENTIFIER="com.idega.block.finance";
  protected IWResourceBundle iwrb;
  protected IWBundle iwb;
  private int iCategoryId = -1;
  private List FinanceObjects = null;

  public FinanceIndex() {

  }
  public FinanceIndex(int iCategoryId){
    this.iCategoryId =  iCategoryId;
  }
  public void setCategoryId(int iCategoryId){
     this.iCategoryId =  iCategoryId;
  }
  public String getBundleIdentifier(){
    return IW_BUNDLE_IDENTIFIER;
  }

  public void main(IWContext iwc){
    iwrb = getResourceBundle(iwc);
    iwb = getBundle(iwc);
    if(iCategoryId <= 0){
      iCategoryId = Finance.parseCategoryId(iwc);
    }

    BlockMenu menu = new BlockMenu();
    addStandardFinanceObjects();
    menu.addParameterToMaintain(Finance.getCategoryParameter(iCategoryId));
    menu.addAll(FinanceObjects);
    add(menu);
  }

  public void addStandardFinanceObjects(){
    if(FinanceObjects == null)
      FinanceObjects = new Vector();
    FinanceObjects.add(0,new Accounts());
    FinanceObjects.add(0,new EntryGroups());
    FinanceObjects.add(0,new TariffAssessments());
    FinanceObjects.add(0,new TariffEditor());
    FinanceObjects.add(0,new TariffIndexEditor());
    FinanceObjects.add(0,new TariffKeyEditor());
    FinanceObjects.add(0,new AccountKeyEditor());
    FinanceObjects.add(0,new PaymentTypeEditor());
  }

  public void addFinanceObject(Block obj){
    if(FinanceObjects == null)
      FinanceObjects = new Vector();
    FinanceObjects.add(obj);
  }

  public void addFinanceObjectAll(java.util.Collection coll){
    if(FinanceObjects == null)
      FinanceObjects = new Vector();
    FinanceObjects.addAll(coll);
  }

  public synchronized Object clone() {
    FinanceIndex obj = null;
    try {
      obj = (FinanceIndex)super.clone();
      obj.FinanceObjects  = FinanceObjects;

    }
    catch(Exception ex) {
      ex.printStackTrace(System.err);
    }
    return obj;
  }

}
