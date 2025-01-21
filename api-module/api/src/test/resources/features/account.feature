Feature: Tests d'intégration de l'api de gestion des comptes

  Background:
    # définition de l'URL par défault
    * url 'http://localhost:8080'

  Scenario: Vérifier la création d'un compte
    Given path 'account'
    And param accountId = '12345'
    And request { }
    When method post
    Then status 201

  Scenario: Vérifier l'ajout d'une somme sur un compte existant
    Given path 'account/deposit'
    And request { 'accountId': '12345', 'amount': '1000' }
    When method put
    Then status 200

  Scenario: Vérifier le retrait d'une somme sur un compte existant
    Given path 'account/withdraw'
    And request { 'accountId': '12345', 'amount': '200' }
    When method put
    Then status 200