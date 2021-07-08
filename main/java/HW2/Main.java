package HW2;

import HW2.entity.Address;
import HW2.entity.Information;
import HW2.service.AddressService;
import HW2.service.InformationService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Address address = new Address();
        AddressService addressService = new AddressService();

        Information information = new Information();
        InformationService informationService = new InformationService();

        Scanner choiceOfList = new Scanner(System.in);
        System.out.println("Enter 1 if you want to go to the \"addresses\" menu or 2 - to \"information\" menu: ");
        int mainMenu = choiceOfList.nextByte();

        switch (mainMenu) {
            case 1:
                Scanner choiceOfAddress = new Scanner(System.in);
                System.out.println("Enter 1 - if you want see all data of address, 2 - if you want create address, 3 - update and 4 - delete: ");
                int menuOfAddress = choiceOfAddress.nextInt();

                switch (menuOfAddress) {
                    case 1:
                        System.out.println(addressService.read());
                        break;
                    case 2:
                        Scanner createCity = new Scanner(System.in);
                        System.out.println("Enter the name of city: ");
                        String city = createCity.nextLine();
                        Scanner createStreet = new Scanner(System.in);
                        System.out.println("Enter the name of street: ");
                        String street = createStreet.nextLine();
                        Scanner createHouse = new Scanner(System.in);
                        System.out.println("Enter the number of house: ");
                        int house = createHouse.nextInt();

                        address.setCity(city);
                        address.setStreet(street);
                        address.setHouse(house);
                        addressService.create(address);
                        break;
                    case 3:
                        Scanner updateCity = new Scanner(System.in);
                        System.out.println("Enter the name of city: ");
                        String city1 = updateCity.nextLine();
                        Scanner updateStreet = new Scanner(System.in);
                        System.out.println("Enter the name of street: ");
                        String street1 = updateStreet.nextLine();
                        Scanner updateHouse = new Scanner(System.in);
                        System.out.println("Enter the number of house: ");
                        int house1 = updateHouse.nextInt();
                        Scanner updateId = new Scanner(System.in);
                        System.out.println("Enter number of id which you want to change: ");
                        int id1 = updateId.nextInt();

                        address.setCity(city1);
                        address.setStreet(street1);
                        address.setHouse(house1);
                        address.setId(id1);
                        addressService.update(address);
                        break;
                    case 4:
                        Scanner deleteId = new Scanner(System.in);
                        System.out.println("Enter number of Id: ");
                        int id = deleteId.nextInt();

                        address.setId(id);
                        addressService.delete(address);
                        break;
                    default:
                        System.out.println("Error in choice of address");
                        System.exit(1);
                }
                break;
            case 2:
                Scanner choiceOfInformation = new Scanner(System.in);
                System.out.println("Enter 1 - if you want see all data of information, 2 - if you want create information, 3 - update and 4 - delete: ");
                int menuOfInformation = choiceOfInformation.nextInt();

                switch (menuOfInformation) {
                    case 1:
                        System.out.println(informationService.read());
                        break;
                    case 2:
                        Scanner createName = new Scanner(System.in);
                        System.out.println("Enter name: ");
                        String name = createName.nextLine();
                        Scanner createSurname = new Scanner(System.in);
                        System.out.println("Enter surname: ");
                        String surname = createSurname.nextLine();
                        Scanner createAge = new Scanner(System.in);
                        System.out.println("Enter age: ");
                        int age = createAge.nextInt();
                        Scanner createPhone = new Scanner(System.in);
                        System.out.println("Enter phone: ");
                        long phone = createPhone.nextLong();

                        information.setName(name);
                        information.setSurname(surname);
                        information.setAge(age);
                        information.setPhone(phone);
                        informationService.create(information);
                        break;
                    case 3:
                        Scanner updateName = new Scanner(System.in);
                        System.out.println("Enter name: ");
                        String name1 = updateName.nextLine();
                        Scanner updateSurname = new Scanner(System.in);
                        System.out.println("Enter surname: ");
                        String surname1 = updateSurname.nextLine();
                        Scanner updateAge = new Scanner(System.in);
                        System.out.println("Enter age: ");
                        int age1 = updateAge.nextInt();
                        Scanner updatePhone = new Scanner(System.in);
                        System.out.println("Enter phone: ");
                        long phone1 = updatePhone.nextLong();
                        Scanner updateId = new Scanner(System.in);
                        System.out.println("Enter number of id which you want to change: ");
                        int id3 = updateId.nextInt();

                        information.setName(name1);
                        information.setSurname(surname1);
                        information.setAge(age1);
                        information.setPhone(phone1);
                        information.setId(id3);
                        informationService.update(information);
                        break;
                    case 4:
                        Scanner deleteId = new Scanner(System.in);
                        System.out.println("Enter number of id which you want to delete: ");
                        int id4 = deleteId.nextInt();
                        information.setId(id4);
                        informationService.delete(information);
                        break;
                    default:
                        System.out.println("Error in information menu");
                        System.exit(2);
                }
                break;
            default:
                System.out.println("Error(You should enter 1 or 2)");
                System.exit(0);
        }
    }
}
