#include <stdio.h>
#include <stdlib.h>
#include<string.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
//struct phoneNumber{
//   char phoneNumber[20];
//   char type[20];
//};
//struct EmailAddress{
//   char email[20];
//   char type[20];
//};
//struct Address{
//	char details[30];
//	char type[20];
//};
struct contact{
	char first_name[20];
	char last_name[20];
	char company[20];
	char phonenumber[30];
	char emailAdsress[30];
	char adsress[1000];
	char phonenumberwork[30];
	char emailAdsresswork[30];
	char adsresswork[1000];
	char dob[30];
};
void addContact();
void editContact();
void deleteContact();
void getContactWithAttributes();
void displayContact();
void search();
char fname[]={"contactDetails.txt"};
char fname1[]={"contactDetails1.txt"};
char titles[10][30]={{"first name"},"last name","company","home phone","work phone","home email","work email","home address","work address","DOB"};
int main(){
	
	int condition=1;
			int choice = -1;
	while(1){
	

		system("cls");
		printf("CONTACT MANAGEMENT SYSTEM\n");
		printf("1.Add contact\n");
		printf("2.Edit contact\n");
		printf("3.Delete contact\n");
		printf("4.Get contacts using attributes\n");
		printf("5.Display contact\n");
		printf("6.Search contact\n");
		printf("0.Exit\n");
		printf("\nPlease enter your choice: ");
		fflush(stdin);
		scanf("%d",&choice);
		//printf("%d", choice);
		switch (choice){
			case 1: addContact();
			        break;
			case 2: editContact();
			        break;
			case 3: deleteContact();
			        break;
			case 4: getContactWithAttributes();
			        break;
			case 5: displayContact();
			         break;        
			case 6: search();  
			         break;       
			case 0: return;	
			default:
			        break; 
			       
									        
			
		}
	}
	
}

//=====================================================ADD-CONTACT-FUNCTION=================================================================================//
void addContact(){
	FILE *fp,*fp1;
    
	struct contact *c1=malloc(sizeof(struct contact));
	int i=0,phone=0,address=0,email=0;
	fp=fopen(fname,"ab");
	fp1=fopen(fname1,"ab");
  
   printf("\nENTER DETAILS(enter nil for not needed fields)\n\n");
	printf("Enter name \n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->first_name);

	//fgets(sizeof(c1->first_name),c1->first_name,stdin);
	if(strcmp(c1->first_name,"nil")==0){
		strcpy(c1->first_name,"-");
	}
	printf("Enter last name\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->last_name);
	
	//fgets(sizeof(c1->last_name),c1->last_name,stdin);
	if(strcmp(c1->last_name,"nil")==0){
		strcpy(c1->last_name,"-");
	}
	
	printf("Enter company\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->company);
	//fgets(sizeof(c1->company),c1->company,stdin);
	if(strcmp(c1->company,"nil")==0){
		strcpy(c1->company,"-");
	}
	printf("Enter home phone number\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->phonenumber);
//fgets(sizeof(c1->phonenumber),c1->phonenumber,stdin);
	if(strcmp(c1->phonenumber,"nil")==0){
		strcpy(c1->phonenumber,"-");
	}
	printf("Enter work phone number\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->phonenumberwork);
//fgets(sizeof(c1->phonenumberwork),c1->phonenumberwork,stdin);
	if(strcmp(c1->phonenumberwork,"nil")==0){
		strcpy(c1->phonenumberwork,"-");
	}
	printf("Enter home email adress\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->emailAdsress);
//fgets(sizeof(c1->emailAdsress),c1->emailAdsress,stdin);
	if(strcmp(c1->emailAdsress,"nil")==0){
		strcpy(c1->emailAdsress,"-");
	}
	printf("Enter work email adress\n");
	scanf("%[^\n]%*c",c1->emailAdsresswork);
	//fgets(sizeof(c1->emailAdsresswork),c1->emailAdsresswork,stdin);
	if(strcmp(c1->emailAdsresswork,"nil")==0){
		strcpy(c1->emailAdsresswork,"-");
	}
	printf("Enter home adress\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->adsress);
//	fgets(sizeof(c1->adsress),c1->adsress,stdin);
	if(strcmp(c1->adsress,"nil")==0){
		strcpy(c1->adsress,"-");
	}
	printf("Enter work adress\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->adsresswork);
//	fgets(sizeof(c1->adsresswork),c1->adsresswork,stdin);
	if(strcmp(c1->adsresswork,"nil")==0){
		strcpy(c1->adsresswork,"-");
	}
	printf("Enter dob\n");
	fflush(stdin);
	scanf("%[^\n]%*c",c1->dob);
//	fgets(sizeof(c1->dob),c1->dob,stdin);
	if(strcmp(c1->dob,"nil")==0){
		strcpy(c1->dob,"-");
	}



fprintf(fp,"%s,",c1->first_name);
fprintf(fp,"%s,",c1->last_name);
fprintf(fp,"%s,",c1->company);
fprintf(fp,"%s,",c1->phonenumber);
fprintf(fp,"%s,",c1->phonenumberwork);
fprintf(fp,"%s,",c1->emailAdsress);
fprintf(fp,"%s,",c1->emailAdsresswork);
fprintf(fp,"%s,",c1->adsress);
fprintf(fp,"%s,",c1->adsresswork);
fprintf(fp,"%s",c1->dob);
fprintf(fp,"\n");
fclose(fp);
printf("\nCONTACT ADDED SUCCESSFULLY\n");
	printf("\nPress enter to continue ");
getch();
}


	
	
//=====================================================DISPLAY-SEARCHED-CONTACT-FUNCTION=================================================================================//
void displaySingleContact(char arr[10][20]){
	if(!strcmp(arr[0],"")==0)
	    	printf("\nfirstname      : %s\n",arr[0]);
	if(!strcmp(arr[1],"")==0)
     		printf("lastname       : %s\n",arr[1]);
	if(!strcmp(arr[2],"")==0)
	      printf("company        : %s\n",arr[2]);
	if(!strcmp(arr[3],"")==0)
	     printf("home phonenumber: %s\n",arr[3]);
	if(!strcmp(arr[4],"")==0)
			printf("work phonenumber: %s\n",arr[4]);
	if(!strcmp(arr[5],"")==0)
			printf("home email     : %s\n",arr[5]);
	if(!strcmp(arr[6],"")==0)
			printf("work email     : %s\n",arr[6]);
	if(!strcmp(arr[7],"")==0)
			printf("home address   : %s\n",arr[7]);
	if(!strcmp(arr[8],"")==0)
			printf("work address   : %s\n",arr[8]);
	if(!strcmp(arr[9],"")==0)
			printf("dob            : %s\n",arr[9]);
		
	
	
	return;
}

//=====================================================GET-CONTACT-FUNCTION=================================================================================//
void getContactWithAttributes(){
	int choice,i,flag=0;
	char value[200];
	FILE *fp;
	printf("\nENTER AN OPTION\n");
	printf("\n1.Firstname\n");
		printf("2.Lastname\n");
		printf("3.Company name\n");
		printf("4.Home phone\n");
		printf("5.Work phone\n");
		printf("6.Home email\n");
		printf("7.Work email\n");
		printf("8.Home address\n");
		printf("9.Work address\n");
		printf("10.DOB\n");
		scanf("%d",&choice);
		fflush(stdin);
		switch(choice){
			case 1:
			printf("Enter firstname: ");
			scanf("%[^\n]%*c",value);
			break;
		case 2:
			printf("Enter lastname: ");
			scanf("%[^\n]%*c",value);
			break;
		case 3:
			printf("Enter company: ");
			scanf("%[^\n]%*c",value);
			break;
		case 4:
			printf("Enter home phone: ");
			scanf("%[^\n]%*c",value);
			break;
		case 5:
			printf("Enter work phone: ");
			scanf("%[^\n]%*c",value);
			break;	
		case 6:
			printf("Enter home email: ");
			scanf("%[^\n]%*c",value);
			break;
		case 7:
			printf("Enter work email: ");
			scanf("%[^\n]%*c",value);
			break;	
		case 8:
			printf("Enter home address: ");
			scanf("%[^\n]%*c",value);
			break;
			
		case 9:
			printf("Enter work address: ");
			scanf("%[^\n]%*c",value);
			break;		
		case 10:
			printf("Enter dob: ");
			scanf("%[^\n]%*c",value);
			break;			
		}
	
		fp=fopen(fname,"rb");
  char line[200];
  
	while(fgets(line,sizeof(line),fp)!=NULL){
		char strings[10][20]={NULL};
		i=0;
		char *token=strtok(line,",");
		while(token!=NULL){
		
			strcpy(strings[i],token);
				//printf("%s\n",strings[i]);
			token=strtok(NULL,",");
			i++;
		}
		
			switch(choice){
			case 1:
			if(strcmp(strings[choice-1],value)==0){
		     flag++;
		        displaySingleContact(strings);
			
		}
			 break;
		case 2:
			if(strcmp(strings[choice-1],value)==0){
	       	flag++;
		        displaySingleContact(strings);
			
		}
			 break;
		case 3:
			if(strcmp(strings[choice-1],value)==0){
		         flag++;
		        displaySingleContact(strings);
			
		}
			 break;
		case 4:
		if(strcmp(strings[choice-1],value)==0){
		         flag++;
		        displaySingleContact(strings);
			
		}
			 break;
		case 5:
			if(strcmp(strings[choice-1],value)==0){
		          flag++;
		        displaySingleContact(strings);
		
		}
			 break;	
		case 6:
			if(strcmp(strings[choice-1],value)==0){
		          flag++;
		        displaySingleContact(strings);
			
		}
			 break;
		case 7:
			if(strcmp(strings[choice-1],value)==0){
		          flag++;
		        displaySingleContact(strings);
			
		}
			 break;
		case 8:
			if(strcmp(strings[choice-1],value)==0){
		          flag++;
		        displaySingleContact(strings);
			
		}
			 break;
			
		case 9:
			if(strcmp(strings[choice-1],value)==0){
		         flag++;
		        displaySingleContact(strings);
			
		}
			 break;		
		case 10:
			if(strcmp(strings[choice-1],value)==0){
		          flag++;
		        displaySingleContact(strings);
			
		}
			 break;	
			 case 0:return;	
		default:
			 // printf("Enter a valid option");
		       break;	 	
		}
			
		

	}
	fclose(fp);
	
	if(flag==0){
		printf("NO RECORD MATCHES WITH GIVEN DATA");
			//printf("\nPress enter to continue ");
		//getch();
	}
	else{
	//	printf("\nflag=%d",flag);
	}
		printf("\nPress enter to continue ");
	getch();
}


//=====================================================DISPLAY-CONTACT-FUNCTION=================================================================================//

void displayContact(){
int i=0,flag=0;
	FILE *fp;
	char val[20];
	
	struct contact *c1=malloc(sizeof(struct contact));
	
	fp=fopen(fname,"rb");
  char line[200];
  
	while(fgets(line,sizeof(line),fp)){
		char strings[10][20];
		i=0;
		char *token=strtok(line,",");
	
		while(token!=NULL&&i<10){
		      
			strcpy(strings[i],token);
			
				printf(" %s          : %s\n",titles[i],strings[i]);
			token=strtok(NULL,",");
		
		//	printf("t=%d",strlen(token));
			i++;
		}
		flag++;
	}
	if(flag==0){
		printf("NO RECORDS PRESENT");
	}
	fclose(fp);
		printf("\nPress enter to continue ");
	getch();
}
//=====================================================DELETE-CONTACT-FUNCTION=================================================================================//


void deleteContact(){
	int i=0,cur=0,flag=0, first=0;
	int second=0,j=0;
	FILE *fp,*fp1;
	struct contact *c=malloc(sizeof(struct contact));
	char firstname[200];
	char lastname[200];
	char newvalue[500];
	int found=0;
	fp=fopen(fname,"rb");
	fp1=fopen("temp.txt","wb");
	fflush(stdin);
	printf("\nEnter first name of the contact you want to delete: ");
	scanf("%[^\n]%*c",firstname);
	printf("\nEnter last name of the contact you want to delete: ");
	scanf("%[^\n]%*c",lastname);
	 
 	char line[200];
 	cur=0;
	while(fgets(line,sizeof(line),fp)!=NULL){
			
			 char strings[10][20]={NULL};
			 i=0;
		//	 printf("innnn while\n\n\n\n\n\n\nin while");
		    	char *token=strtok(line,",");
		while(token!=NULL){
				strcpy(strings[i],token);
				//printf("%s\n",strings[i]);
			    token=strtok(NULL,",");
				i++;
		}
		
	 
 cur++;
	struct contact* c[100];
	if(strcmp(strings[0],firstname)==0&&strcmp(strings[1],lastname)==0){
		c[cur-1]=(struct contact*)malloc(sizeof(struct contact));
		strcpy(c[cur-1]->first_name,strings[0]);
		strcpy(c[cur-1]->first_name,strings[1]);
		strcpy(c[cur-1]->first_name,strings[2]);
		strcpy(c[cur-1]->first_name,strings[3]);
		strcpy(c[cur-1]->first_name,strings[4]);
		strcpy(c[cur-1]->first_name,strings[5]);
		strcpy(c[cur-1]->first_name,strings[6]);
		strcpy(c[cur-1]->first_name,strings[7]);
		strcpy(c[cur-1]->first_name,strings[8]);
		strcpy(c[cur-1]->first_name,strings[9]);
		found++;
		printf("%s,",strings[0]);
		printf("%s,",strings[1]);
		printf("%s,",strings[2]);
		printf("%s,",strings[3]);
		printf("%s,",strings[4]);
		printf("%s,",strings[5]);
		printf("%s,",strings[6]);
		printf("%s,",strings[7]);
		printf("%s,",strings[8]);
		printf("%s\n",strings[9]);
		printf("RECORD NUMBER:%d\n\n",cur);
		fprintf(fp1,"%s,",strings[0]);
		fprintf(fp1,"%s,",strings[1]);
		fprintf(fp1,"%s,",strings[2]);
		fprintf(fp1,"%s,",strings[3]);
		fprintf(fp1,"%s,",strings[4]);
		fprintf(fp1,"%s,",strings[5]);
		fprintf(fp1,"%s,",strings[6]);
		fprintf(fp1,"%s,",strings[7]);
		fprintf(fp1,"%s,",strings[8]);
		fprintf(fp1,"%s",strings[9]);
	}else{
		
	
	    fprintf(fp1,"%s,",strings[0]);
		fprintf(fp1,"%s,",strings[1]);
		fprintf(fp1,"%s,",strings[2]);
		fprintf(fp1,"%s,",strings[3]);
		fprintf(fp1,"%s,",strings[4]);
		fprintf(fp1,"%s,",strings[5]);
		fprintf(fp1,"%s,",strings[6]);
		fprintf(fp1,"%s,",strings[7]);
		fprintf(fp1,"%s,",strings[8]);
		fprintf(fp1,"%s",strings[9]);
		
	}

	
}
	fclose(fp);
	fclose(fp1);
	 if(found>=1){
		printf("\nEnter record to be deleted\n");
		scanf("%d",&first);
			//printf("\nenter record to be deleted%d\n",first);
			//getch();
	}
	if(found==0){
		printf("SORRY NO MATCHING CONTACT");
			printf("\nPress enter to continue ");
		getch();
	}
	
	else{
		cur=1;
		fp=fopen(fname,"wb");
		fp1=fopen("temp.txt","rb");
	while(fgets(line,sizeof(line),fp1)){
		
	if(cur!=first){
	fputs(line,fp);
	}
	
		cur++;
	//	fputs("\n",fp);
	}
	printf("\nCONTACT DELETED SUCCESSFULLY\n");
	printf("\nPress enter to continue ");
getch();
}
fclose(fp);
fclose(fp1);
}

//=====================================================EDIT-CONTACT-FUNCTION=================================================================================//
void editContact(){
		int i=0,cur=0,first=0;
		FILE *fp,*fp1;
		struct contact *c=malloc(sizeof(struct contact));
		char firstname[200];
	 	char lastname[200];
		char newvalue[200];
		int found=0;
		fp=fopen(fname,"rb");
		fp1=fopen("temp.txt","wb");
		fflush(stdin);
		printf("\nEnter first name of the contact you want to edit: ");
		scanf("%[^\n]%*c",firstname);
		printf("\nEnter last name of the contact you want to edit: ");
		scanf("%[^\n]%*c",lastname);
 		char line[200];
 		cur=0;
		while(fgets(line,sizeof(line),fp)!=NULL){
	 	 	
		 	char strings[10][20]={NULL};
		 	i=0;
			 char *token=strtok(line,",");
	     	while(token!=NULL){
				 strcpy(strings[i],token);
				 //printf("%s\n",strings[i]);
			     token=strtok(NULL,",");
			     i++;
			     
		}
		cur++;
		if(strcmp(strings[0],firstname)==0&&strcmp(strings[1],lastname)==0){
		
			found++;
		printf("%s\n",strings[0]);
		printf("%s\n",strings[1]);
		printf("%s\n",strings[2]);
		printf("%s\n",strings[3]);
		printf("%s\n",strings[4]);
		printf("%s\n",strings[5]);
		printf("%s\n",strings[6]);
		printf("%s\n",strings[7]);
		printf("%s\n",strings[8]);
		printf("%s\n",strings[9]);
		printf("RECORD NUMBER:%d\n",cur);
		
		fprintf(fp1,"%s,",strings[0]);
		fprintf(fp1,"%s,",strings[1]);
		fprintf(fp1,"%s,",strings[2]);
		fprintf(fp1,"%s,",strings[3]);
		fprintf(fp1,"%s,",strings[4]);
		fprintf(fp1,"%s,",strings[5]);
		fprintf(fp1,"%s,",strings[6]);
		fprintf(fp1,"%s,",strings[7]);
		fprintf(fp1,"%s,",strings[8]);
		fprintf(fp1,"%s",strings[9]);
		
	}
	
	else {
		
		
	    fprintf(fp1,"%s,",strings[0]);
		fprintf(fp1,"%s,",strings[1]);
		fprintf(fp1,"%s,",strings[2]);
		fprintf(fp1,"%s,",strings[3]);
		fprintf(fp1,"%s,",strings[4]);
		fprintf(fp1,"%s,",strings[5]);
		fprintf(fp1,"%s,",strings[6]);
		fprintf(fp1,"%s,",strings[7]);
		fprintf(fp1,"%s,",strings[8]);
		fprintf(fp1,"%s",strings[9]);
	}

	
}
	fclose(fp);
	fclose(fp1);
	if(found>=1){
			printf("\nEnter record number to be edited\n");
		scanf("%d",&first);
		//	printf("\nenter record to be edited%d\n",first);
			
			//getch();
			
	}
	if(found==0){
		printf("SORRY NO MATCHING CONTACT");
	//	printf("\nPress enter to continue ");
	//	getch();
	}else{
		fp=fopen(fname,"wb");
		fp1=fopen("temp.txt","rb");
		cur=1;
	while(fgets(line,sizeof(line),fp1)){
	char	strings[10][20]={NULL};
		 	i=0;
			 char *token=strtok(line,",");
	     	while(token!=NULL){
				 strcpy(strings[i],token);
				 //printf("%s\n",strings[i]);
			     token=strtok(NULL,",");
			     i++;
			     
		}
	//	printf("hihihihih");
	if(cur==first){
		
			int choice;
			system("cls");
		printf("\n1.Firstname\n");
		printf("2.Lastname\n");
		printf("3.Company name\n");
		printf("4.Home phone\n");
		printf("5.Work phone\n");
		printf("6.Home email\n");
		printf("7.Work email\n");
		printf("8.Home address\n");
		printf("9.Work address\n");
		printf("10.DOB\n");
		printf("0.Exit\n");
		printf("Enter choice to edit(1-10)\n");
		scanf("%d",&choice);
		
		fflush(stdin);
		switch(choice){
			case 1:{
				printf("Enter new firstname: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				
				break;
			}
			case 2:{
				printf("Enter new lastname: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 3:{
				printf("Enter new company name: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 4:{
				printf("Enter new home phone: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 5:{
				printf("Enter new work phone: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 6:{
				printf("Enter new home email: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 7:{
				printf("enter new work email: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 8:{
				printf("Enter new home address: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 9:{
				printf("Enter new work address: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 10:{
				printf("Enter new DOB: ");
				scanf("%[^\n]%*c",newvalue);
				strcpy(strings[choice-1],newvalue);
				break;
			}
			case 0:{
				return;
			}
			default:break;
		}
	}
		 fprintf(fp,"%s,",strings[0]);
		fprintf(fp,"%s,",strings[1]);
		fprintf(fp,"%s,",strings[2]);
		fprintf(fp,"%s,",strings[3]);
		fprintf(fp,"%s,",strings[4]);
		fprintf(fp,"%s,",strings[5]);
		fprintf(fp,"%s,",strings[6]);
		fprintf(fp,"%s,",strings[7]);
		fprintf(fp,"%s,",strings[8]);
		fprintf(fp,"%s",strings[9]);
cur++;
		
	}
		printf("CONTACT EDITED SUCCESFULLY");
}
fclose(fp);
fclose(fp1);
	printf("\nPress enter to continue ");
getch();
}
//=====================================================SEARCH-CONTACT-FUNCTION========================================================//
void search(){
	int flag=0,i=0;
	char value[200];
	FILE *fp;
	fflush(stdin);
	printf("\nEnter value to be searched : ");
	scanf("%[^\n]%*c",value);
	fp=fopen(fname,"rb");

	char line[200];
	while(fgets(line,sizeof(line),fp)){
		if(strstr(line,value)){
			char strings[10][200]={NULL};
			i=0;
			char *token=strtok(line,",");
		  while(token!=NULL){
		      
			strcpy(strings[i],token);
				
			token=strtok(NULL,",");
			printf("%s              : %s\n",titles[i],strings[i]);
			i++;
			flag++;
			
		}
	  
	  
		}
		
	}
	if(flag==0){
		printf("\nNO VALUES ARE MATCHED\n");
		//printf("\nPress enter to continue ");
		//getch();
	}
	fclose(fp);
	printf("\nPress enter to continue ");
	getch();
}
