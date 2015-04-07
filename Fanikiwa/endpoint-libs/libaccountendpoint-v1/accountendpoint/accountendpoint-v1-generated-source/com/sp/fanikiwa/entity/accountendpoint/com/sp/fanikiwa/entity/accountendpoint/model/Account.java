/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-03-26 20:30:19 UTC)
 * on 2015-04-06 at 13:17:52 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.accountendpoint.model;

/**
 * Model definition for Account.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the accountendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Account extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long accountID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String accountName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String accountNo;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private AccountType accounttype;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double accruedInt;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double bal30;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double bal60;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double bal90;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double balOver90;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double bookBalance;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String branch;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double clearedBalance;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean closed;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Coadet coadet;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Customer customer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double intRate30;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double intRate60;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double intRate90;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double intRateOver90;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double interestRate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double limit;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer limitCheckFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer limitFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer passFlag;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getAccountID() {
    return accountID;
  }

  /**
   * @param accountID accountID or {@code null} for none
   */
  public Account setAccountID(java.lang.Long accountID) {
    this.accountID = accountID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAccountName() {
    return accountName;
  }

  /**
   * @param accountName accountName or {@code null} for none
   */
  public Account setAccountName(java.lang.String accountName) {
    this.accountName = accountName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAccountNo() {
    return accountNo;
  }

  /**
   * @param accountNo accountNo or {@code null} for none
   */
  public Account setAccountNo(java.lang.String accountNo) {
    this.accountNo = accountNo;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public AccountType getAccounttype() {
    return accounttype;
  }

  /**
   * @param accounttype accounttype or {@code null} for none
   */
  public Account setAccounttype(AccountType accounttype) {
    this.accounttype = accounttype;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAccruedInt() {
    return accruedInt;
  }

  /**
   * @param accruedInt accruedInt or {@code null} for none
   */
  public Account setAccruedInt(java.lang.Double accruedInt) {
    this.accruedInt = accruedInt;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getBal30() {
    return bal30;
  }

  /**
   * @param bal30 bal30 or {@code null} for none
   */
  public Account setBal30(java.lang.Double bal30) {
    this.bal30 = bal30;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getBal60() {
    return bal60;
  }

  /**
   * @param bal60 bal60 or {@code null} for none
   */
  public Account setBal60(java.lang.Double bal60) {
    this.bal60 = bal60;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getBal90() {
    return bal90;
  }

  /**
   * @param bal90 bal90 or {@code null} for none
   */
  public Account setBal90(java.lang.Double bal90) {
    this.bal90 = bal90;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getBalOver90() {
    return balOver90;
  }

  /**
   * @param balOver90 balOver90 or {@code null} for none
   */
  public Account setBalOver90(java.lang.Double balOver90) {
    this.balOver90 = balOver90;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getBookBalance() {
    return bookBalance;
  }

  /**
   * @param bookBalance bookBalance or {@code null} for none
   */
  public Account setBookBalance(java.lang.Double bookBalance) {
    this.bookBalance = bookBalance;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBranch() {
    return branch;
  }

  /**
   * @param branch branch or {@code null} for none
   */
  public Account setBranch(java.lang.String branch) {
    this.branch = branch;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getClearedBalance() {
    return clearedBalance;
  }

  /**
   * @param clearedBalance clearedBalance or {@code null} for none
   */
  public Account setClearedBalance(java.lang.Double clearedBalance) {
    this.clearedBalance = clearedBalance;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getClosed() {
    return closed;
  }

  /**
   * @param closed closed or {@code null} for none
   */
  public Account setClosed(java.lang.Boolean closed) {
    this.closed = closed;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Coadet getCoadet() {
    return coadet;
  }

  /**
   * @param coadet coadet or {@code null} for none
   */
  public Account setCoadet(Coadet coadet) {
    this.coadet = coadet;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * @param customer customer or {@code null} for none
   */
  public Account setCustomer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getIntRate30() {
    return intRate30;
  }

  /**
   * @param intRate30 intRate30 or {@code null} for none
   */
  public Account setIntRate30(java.lang.Double intRate30) {
    this.intRate30 = intRate30;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getIntRate60() {
    return intRate60;
  }

  /**
   * @param intRate60 intRate60 or {@code null} for none
   */
  public Account setIntRate60(java.lang.Double intRate60) {
    this.intRate60 = intRate60;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getIntRate90() {
    return intRate90;
  }

  /**
   * @param intRate90 intRate90 or {@code null} for none
   */
  public Account setIntRate90(java.lang.Double intRate90) {
    this.intRate90 = intRate90;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getIntRateOver90() {
    return intRateOver90;
  }

  /**
   * @param intRateOver90 intRateOver90 or {@code null} for none
   */
  public Account setIntRateOver90(java.lang.Double intRateOver90) {
    this.intRateOver90 = intRateOver90;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getInterestRate() {
    return interestRate;
  }

  /**
   * @param interestRate interestRate or {@code null} for none
   */
  public Account setInterestRate(java.lang.Double interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLimit() {
    return limit;
  }

  /**
   * @param limit limit or {@code null} for none
   */
  public Account setLimit(java.lang.Double limit) {
    this.limit = limit;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getLimitCheckFlag() {
    return limitCheckFlag;
  }

  /**
   * @param limitCheckFlag limitCheckFlag or {@code null} for none
   */
  public Account setLimitCheckFlag(java.lang.Integer limitCheckFlag) {
    this.limitCheckFlag = limitCheckFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getLimitFlag() {
    return limitFlag;
  }

  /**
   * @param limitFlag limitFlag or {@code null} for none
   */
  public Account setLimitFlag(java.lang.Integer limitFlag) {
    this.limitFlag = limitFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getPassFlag() {
    return passFlag;
  }

  /**
   * @param passFlag passFlag or {@code null} for none
   */
  public Account setPassFlag(java.lang.Integer passFlag) {
    this.passFlag = passFlag;
    return this;
  }

  @Override
  public Account set(String fieldName, Object value) {
    return (Account) super.set(fieldName, value);
  }

  @Override
  public Account clone() {
    return (Account) super.clone();
  }

}
