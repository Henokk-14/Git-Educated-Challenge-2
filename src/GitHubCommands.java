package src;
import git.tools.client.GitSubprocessClient;

import java.util.Locale;

public class GitHubCommands {

  public GitHubCommands(){ }

  public String GitStatus(GitSubprocessClient Client, String repoString){
    try {
      //System.out.println(repoString + " repoString");
    String stat  = Client.gitStatus();
    return stat +  "\n\n"+ "Next input file name that you want to add before you click Add. Enter ".toUpperCase(Locale.ROOT)+ "AddAll" + " if you want to add all of the files in the repo".toUpperCase(Locale.ROOT);
    } catch (RuntimeException e){
     return "You have entered the wrong repo please try again:)";
    }
  }
  public String GitAdd(GitSubprocessClient gitSubprocessClient1,String filename) {
    try {
    String gitAddFile = gitSubprocessClient1.gitAddFile(filename);
    System.out.println(gitAddFile);
    if(gitAddFile.contains("AddAll")){
      gitSubprocessClient1.gitAddAll();
      return "All files have been added click Status to see all files added" +  "\n\n"+ "Next before clicking commit input your commit message for the push.".toUpperCase(Locale.ROOT);
    }
    if(gitAddFile.contains("fatal")){
    return  gitAddFile;
    }
    if(filename.length() == 0){
      return filename+ "Can't add an empty file please enter a correct file";
    }
    else
      return  "File: "+ filename+ " added" +  "\n\n"+ "Next before clicking commit input your commit message for the push or add another file".toUpperCase(Locale.ROOT);
    } catch (Exception e) {
      e.printStackTrace();
      return "Error file name entered incorrect file: "+ filename + " Doesn't exist in scope" ;
    }
  }

  public String Commit(GitSubprocessClient gitSubprocessClient, String CommitMsg){
    try{
      String commit = gitSubprocessClient.gitCommit(CommitMsg);
      return commit + "\n\nNext before clicking push input the name of the branch you want to push";
    } catch (Exception e) {
      return "ERROR your commit message was not accepted try again";
    }
  }

  public String Push(GitSubprocessClient gitSubprocessClient, String BranchName){
    try{
      String push = gitSubprocessClient.gitPush(BranchName);
      return push;
    } catch (Exception e) {
      return "ERROR your push was not successfully please try again. please make sure the branch exists on GitHub";
    }
  }
}
