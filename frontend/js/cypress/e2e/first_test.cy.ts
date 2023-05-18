

describe("Index page", () => {
    it("should display something", () => {
        cy.visit("/");
        cy.get("[data-cy=test]").should("contain","Välkommen");
    });
});

describe("Xml Poems page", () => {
    beforeEach(() => {
        cy.intercept('GET', 'http://localhost:8080/xmlPoemNames', { fixture: 'xmlnameId'})  
        cy.intercept('GET', 'http://localhost:8080/apophthegms/22898', { fixture: 'apophthegms'})   
        cy.visit("/xmlpoems");  
    });
    
    it("tst", () =>  {
        cy.get("[data-cy=tests]").should("have.length",10);
        cy.get("[data-cy=tests]").eq(9).click();
        cy.get("[data-cy=cis]").should("have.length",3);

    });
});
