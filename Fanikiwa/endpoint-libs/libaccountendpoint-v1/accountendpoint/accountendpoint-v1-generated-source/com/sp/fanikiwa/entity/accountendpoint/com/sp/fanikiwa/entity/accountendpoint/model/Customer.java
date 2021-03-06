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
 * Model definition for Customer.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the accountendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Customer extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String address;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String billToAddress;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String billToEmail;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String billToName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String billToTelephone;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String branch;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime createdDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long customerId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String customerNo;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String email;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long memberId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String name;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Organization organization;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String telephone;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAddress() {
    return address;
  }

  /**
   * @param address address or {@code null} for none
   */
  public Customer setAddress(java.lang.String address) {
    this.address = address;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBillToAddress() {
    return billToAddress;
  }

  /**
   * @param billToAddress billToAddress or {@code null} for none
   */
  public Customer setBillToAddress(java.lang.String billToAddress) {
    this.billToAddress = billToAddress;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBillToEmail() {
    return billToEmail;
  }

  /**
   * @param billToEmail billToEmail or {@code null} for none
   */
  public Customer setBillToEmail(java.lang.String billToEmail) {
    this.billToEmail = billToEmail;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBillToName() {
    return billToName;
  }

  /**
   * @param billToName billToName or {@code null} for none
   */
  public Customer setBillToName(java.lang.String billToName) {
    this.billToName = billToName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBillToTelephone() {
    return billToTelephone;
  }

  /**
   * @param billToTelephone billToTelephone or {@code null} for none
   */
  public Customer setBillToTelephone(java.lang.String billToTelephone) {
    this.billToTelephone = billToTelephone;
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
  public Customer setBranch(java.lang.String branch) {
    this.branch = branch;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate createdDate or {@code null} for none
   */
  public Customer setCreatedDate(com.google.api.client.util.DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId customerId or {@code null} for none
   */
  public Customer setCustomerId(java.lang.Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCustomerNo() {
    return customerNo;
  }

  /**
   * @param customerNo customerNo or {@code null} for none
   */
  public Customer setCustomerNo(java.lang.String customerNo) {
    this.customerNo = customerNo;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getEmail() {
    return email;
  }

  /**
   * @param email email or {@code null} for none
   */
  public Customer setEmail(java.lang.String email) {
    this.email = email;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getMemberId() {
    return memberId;
  }

  /**
   * @param memberId memberId or {@code null} for none
   */
  public Customer setMemberId(java.lang.Long memberId) {
    this.memberId = memberId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * @param name name or {@code null} for none
   */
  public Customer setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Organization getOrganization() {
    return organization;
  }

  /**
   * @param organization organization or {@code null} for none
   */
  public Customer setOrganization(Organization organization) {
    this.organization = organization;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getTelephone() {
    return telephone;
  }

  /**
   * @param telephone telephone or {@code null} for none
   */
  public Customer setTelephone(java.lang.String telephone) {
    this.telephone = telephone;
    return this;
  }

  @Override
  public Customer set(String fieldName, Object value) {
    return (Customer) super.set(fieldName, value);
  }

  @Override
  public Customer clone() {
    return (Customer) super.clone();
  }

}
