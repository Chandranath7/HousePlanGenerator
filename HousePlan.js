// Converted and enhanced version of your Java code to JavaScript // This version runs in browser and includes a form for input and output display

function generateHousePlan() { const totalArea = parseInt(document.getElementById("totalArea").value); const bedrooms = parseInt(document.getElementById("bedrooms").value); const bathrooms = parseInt(document.getElementById("bathrooms").value); const balcony = document.getElementById("balcony").value === "1"; const studyRoom = document.getElementById("studyRoom").value === "1"; const floors = parseInt(document.getElementById("floors").value);

// Fixed room sizes (sqft) const masterBedroomArea = 150; const normalBedroomArea = 120; const bathroomArea = 60; const kitchenArea = 80; const livingArea = 150; const balconyArea = 50; const studyRoomArea = 70;

let totalUsedArea = 0;

if (bedrooms > 0) { totalUsedArea += masterBedroomArea; totalUsedArea += (bedrooms - 1) * normalBedroomArea; }

totalUsedArea += bathrooms * bathroomArea; totalUsedArea += kitchenArea; totalUsedArea += livingArea;

if (balcony) totalUsedArea += balconyArea; if (studyRoom) totalUsedArea += studyRoomArea;

const totalUsedAcrossFloors = totalUsedArea * floors; const freeSpace = totalArea - totalUsedAcrossFloors;

// Display output const output = ` ------- House Plan Summary -------<br>
