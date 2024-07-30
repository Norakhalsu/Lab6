package com.example.validation.Model;



public class Validation_Checklist_Creation {
    /*
         Title : Finance Data Validation Checklist

        Model_Client_Information : ID , name , phone number , email ,

          - ID : id must be a numbers          @Pattern
                 id length minimum 4 integers   @Size
                 id can not be empty            @NotEmpty

        - Name:  name is require cannot be empty   @NotEmpty
                minimum name length is 4           @Size
                name only charachter              @Pattern

       - phone number: only integer number              @Pattern
                       length minimum is 8              @Size
                       Phone number must start with '05'  @Pattern

         - email :  is reqauire cannot be empty   @NotEmpty
                    must be valid format email   @email




            Model_Transaction_Currency: date , amount , transaction type , Account IDs

            - date :  date input value                      @pattern = "yyyy/MM/dd"
                                  date input value validate and format  @DateTimeFormat(pattern = "yyyy-MM-dd")
                                  transaction date id require            @NotNull

               - amount :    cannot be empty               @NotNull
                             must be positive and integer  @Positive
                             minimum number is             @DecimalMin
                             maximum number is             @DecimalMax

          - transaction type  : can not be empty            @NotEmpty
                             it must be (REQUIRED , REQUIRES_NEW ,SUPPORTS or MANDATORY   @Pattern

        -Account ID : cannot be null   @NotEmpty
                      length must be more than 25  @Size
                       must be integers      @Pattern



                Model_Account_Activity: :  transactionId , last date  , withdraw و deposit ,

                          - transactionId :
                           cannot be null  @NotNull
                            transactionDate: should be past date    @Past
                             date format   @Pattern

                                last date : cannot be empty  @NotNull
                                             must be in the past @Past

                           withdraw : must be positive number  @positive
                                         require cannot be null @nNotnull


                             deposit : must be positive number  @positive
                                         require cannot be null @nNotnull




      Model_Another_Account_Bank : id , bank name , owner account name  , amount  , phone number
                                 id :
                                 write id account is require  @NotEmpty
                                 must be integers   @pattern
                                 length more than 35 @Size


                                 bank name :  must be only charchter @pattern
                                             length must be more than 2 @Size
                                             bank name is require  @NotEmpty


                                owner account name : is require @NotEmpty
                                                     length must be more than 8 @Size
                                                     must be String @Pattern

                                          amount : must be positive integers  @Positive
                                                    cannot be empty @NitNull

                                 phone number : write a phone number start with 05 @Pattern
                                                  phone number is require @NotEmpty
                                                  must be integers only    @Pattern


     */

}
